package org.QCMtest.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.QCMtest.model.Question;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

@Entity
@Table(name = "EXAM")
public class Examen implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column
   private String name;

   @Column
   @Temporal(TemporalType.DATE)
   private Date dateDebut;

   @OneToMany
   private Set<Question> questions = new HashSet<Question>();

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Examen))
      {
         return false;
      }
      Examen other = (Examen) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Date getDateDebut()
   {
      return dateDebut;
   }

   public void setDateDebut(Date dateDebut)
   {
      this.dateDebut = dateDebut;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (id != null)
         result += "id: " + id;
      result += ", version: " + version;
      if (name != null && !name.trim().isEmpty())
         result += ", name: " + name;
      if (dateDebut != null)
         result += ", dateDebut: " + dateDebut;
      return result;
   }

   public Set<Question> getQuestions()
   {
      return this.questions;
   }

   public void setQuestions(final Set<Question> questions)
   {
      this.questions = questions;
   }
}