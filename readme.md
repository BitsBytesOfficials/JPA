# JPA(JAVA PERSISTENCE API) is the way to impliment the HIBERNATE using Annotations
 1. it is Alternate use of XML
 
# Annotations

  we must import package
    > import javax.persistence.Entity;
> import javax.persistence.Id;
> import javax.persistence.Table;

  ## @Entity for class 
  ## @Table(name="tableName")
  ## For Primary Key 
      @ID in the field 
 ## for autoIncrement
 
	@GeneratedValue(strategy=GenerationType.AUTO)
  ## join by primary key
	@PrimaryKeyJoinColumn
# > Association Mapping
  1. One to One 
     1.1 Shared Primary Key  [Customer.java and Address.java ]
    . @OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
       this @ mention above the object of the Other class
	   . @OneToOne(targetEntity=Customer.class)
     1.2 Not shared Key
     	@GeneratedValue(strategy = GenerationType.IDENTITY)
  2. One to Many [ Question and Answer.java]
     
  3. Many to One
  4. Many to Many
  
  ## Steps
  1. Open HiberAnnotations Project
  2. Create a Pojo class(Customer) 
  3. create another Pojo Class Address
  4. Mapping both Pojo classes in hibernate.cfg.xml
  5. run that