package fr.uds.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.uds.model.BadAnswer;

/**
 * Backing bean for BadAnswer entities.
 * <p/>
 * This class provides CRUD functionality for all BadAnswer entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class BadAnswerBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving BadAnswer entities
    */

   private Long id;

   public Long getId()
   {
      return this.id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   private BadAnswer badAnswer;

   public BadAnswer getBadAnswer()
   {
      return this.badAnswer;
   }

   public void setBadAnswer(BadAnswer badAnswer)
   {
      this.badAnswer = badAnswer;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "qcm-persistence-unit", type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create()
   {

      this.conversation.begin();
      this.conversation.setTimeout(1800000L);
      return "create?faces-redirect=true";
   }

   public void retrieve()
   {

      if (FacesContext.getCurrentInstance().isPostback())
      {
         return;
      }

      if (this.conversation.isTransient())
      {
         this.conversation.begin();
         this.conversation.setTimeout(1800000L);
      }

      if (this.id == null)
      {
         this.badAnswer = this.example;
      }
      else
      {
         this.badAnswer = findById(getId());
      }
   }

   public BadAnswer findById(Long id)
   {

      return this.entityManager.find(BadAnswer.class, id);
   }

   /*
    * Support updating and deleting BadAnswer entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.badAnswer);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.badAnswer);
            return "view?faces-redirect=true&id=" + this.badAnswer.getId();
         }
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   public String delete()
   {
      this.conversation.end();

      try
      {
         BadAnswer deletableEntity = findById(getId());

         this.entityManager.remove(deletableEntity);
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching BadAnswer entities with pagination
    */

   private int page;
   private long count;
   private List<BadAnswer> pageItems;

   private BadAnswer example = new BadAnswer();

   public int getPage()
   {
      return this.page;
   }

   public void setPage(int page)
   {
      this.page = page;
   }

   public int getPageSize()
   {
      return 10;
   }

   public BadAnswer getExample()
   {
      return this.example;
   }

   public void setExample(BadAnswer example)
   {
      this.example = example;
   }

   public String search()
   {
      this.page = 0;
      return null;
   }

   public void paginate()
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<BadAnswer> root = countCriteria.from(BadAnswer.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<BadAnswer> criteria = builder.createQuery(BadAnswer.class);
      root = criteria.from(BadAnswer.class);
      TypedQuery<BadAnswer> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<BadAnswer> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<BadAnswer> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back BadAnswer entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<BadAnswer> getAll()
   {

      CriteriaQuery<BadAnswer> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(BadAnswer.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(BadAnswer.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final BadAnswerBean ejbProxy = this.sessionContext.getBusinessObject(BadAnswerBean.class);

      return new Converter()
      {

         @Override
         public Object getAsObject(FacesContext context,
               UIComponent component, String value)
         {

            return ejbProxy.findById(Long.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context,
               UIComponent component, Object value)
         {

            if (value == null)
            {
               return "";
            }

            return String.valueOf(((BadAnswer) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private BadAnswer add = new BadAnswer();

   public BadAnswer getAdd()
   {
      return this.add;
   }

   public BadAnswer getAdded()
   {
      BadAnswer added = this.add;
      this.add = new BadAnswer();
      return added;
   }
}
