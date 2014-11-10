package org.QCMtest.view;

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

import org.QCMtest.model.Question;

/**
 * Backing bean for Question entities.
 * <p/>
 * This class provides CRUD functionality for all Question entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class QuestionBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Question entities
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

   private Question question;

   public Question getQuestion()
   {
      return this.question;
   }

   public void setQuestion(Question question)
   {
      this.question = question;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "QCMtest-persistence-unit", type = PersistenceContextType.EXTENDED)
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
         this.question = this.example;
      }
      else
      {
         this.question = findById(getId());
      }
   }

   public Question findById(Long id)
   {

      return this.entityManager.find(Question.class, id);
   }

   /*
    * Support updating and deleting Question entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.question);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.question);
            return "view?faces-redirect=true&id=" + this.question.getId();
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
         Question deletableEntity = findById(getId());

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
    * Support searching Question entities with pagination
    */

   private int page;
   private long count;
   private List<Question> pageItems;

   private Question example = new Question();

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

   public Question getExample()
   {
      return this.example;
   }

   public void setExample(Question example)
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
      Root<Question> root = countCriteria.from(Question.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Question> criteria = builder.createQuery(Question.class);
      root = criteria.from(Question.class);
      TypedQuery<Question> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Question> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String intitule = this.example.getIntitule();
      if (intitule != null && !"".equals(intitule))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("intitule")), '%' + intitule.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Question> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Question entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Question> getAll()
   {

      CriteriaQuery<Question> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Question.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Question.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final QuestionBean ejbProxy = this.sessionContext.getBusinessObject(QuestionBean.class);

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

            return String.valueOf(((Question) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Question add = new Question();

   public Question getAdd()
   {
      return this.add;
   }

   public Question getAdded()
   {
      Question added = this.add;
      this.add = new Question();
      return added;
   }
}
