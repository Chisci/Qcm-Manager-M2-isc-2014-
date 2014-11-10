package fr.uds.model;

import java.lang.Override;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class AbstractAnswer
{
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id;
	   @Version
	   @Column(name = "version")
	   private int version;

   private String text;

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
   
   public String getText()
   {
      return text;
   }

   public void setText(String text)
   {
      this.text = text;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (text != null && !text.trim().isEmpty())
         result += "text: " + text;
      return result;
   }
}