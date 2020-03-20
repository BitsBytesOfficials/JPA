# JPA(JAVA PERSISTENCE API) is the way to impliment the HIBERNATE using Annotations
 1. it is Alternate use of XML
## Mapping
  1. Collection Mapping having 1 POJO Class
  >Multiple POJO's Classes
  2. Component Mapping [Has a relationship]
  3. Inheritance Mapping[Is a relationship]
  4. Association Mapping[Multiple Tables]

 
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
     > Sharing the Primary Key in two tables
        @PrimaryKeyJoinColumn 
     > Primary Key & Foreign Key
         @JoinColumn
     1.1 Shared Primary Key  [Customer.java and Address.java ]
    . @OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
       this @ mention above the object of the Other class
	   . @OneToOne(targetEntity=Customer.class)
     1.2 Not shared Key
     	@GeneratedValue(strategy = GenerationType.IDENTITY)
  2. One to Many [ Question and Answer.java]
        > Primary Key & Foreign Key
             @JoinColumn
  3. Many to Many   [ Cart & Item Classes]
     > @ManyToMany(targetEntity=Item.class,cascade={CascadeType.ALL})
	@JoinTable(name="cart_items",joinColumns={@JoinColumn(name="cart_id")},
	inverseJoinColumns={@JoinColumn(name="item_id")})
  
   1. WE have 2 Classes Item and Cart having Many to Many Relationship so we need one more table
   
  4. Many to One
  
  
  ## Steps
  1. Open HiberAnnotations Project
  2. Create a Pojo class(Customer) 
  3. create another Pojo Class Address
  4. Mapping both Pojo classes in hibernate.cfg.xml
  5. run that