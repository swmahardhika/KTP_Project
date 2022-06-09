/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktp.praktikum;

import com.ktp.praktikum.exceptions.NonexistentEntityException;
import com.ktp.praktikum.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author SWMahardhika
 */
public class DatadataJpaController implements Serializable {

    public DatadataJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ktp_praktikum_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DatadataJpaController() {
    }

    
    public void create(Datadata datadata) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datadata);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatadata(datadata.getId()) != null) {
                throw new PreexistingEntityException("Datadata " + datadata + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datadata datadata) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datadata = em.merge(datadata);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = datadata.getId();
                if (findDatadata(id) == null) {
                    throw new NonexistentEntityException("The datadata with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datadata datadata;
            try {
                datadata = em.getReference(Datadata.class, id);
                datadata.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datadata with id " + id + " no longer exists.", enfe);
            }
            em.remove(datadata);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datadata> findDatadataEntities() {
        return findDatadataEntities(true, -1, -1);
    }

    public List<Datadata> findDatadataEntities(int maxResults, int firstResult) {
        return findDatadataEntities(false, maxResults, firstResult);
    }

    private List<Datadata> findDatadataEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datadata.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Datadata findDatadata(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datadata.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatadataCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datadata> rt = cq.from(Datadata.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
