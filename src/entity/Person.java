
package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttachmentRef;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="street",column=@Column(name="home_street")),
			@AttributeOverride(name="city",column=@Column(name="home_city")),
			@AttributeOverride(name="zipcode",column=@Column(name="Address_zipcode"))
	})
	private Address homeaddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street",column = @Column(name = "billing_street")),
			@AttributeOverride(name = "city",column = @Column(name = "Billing_city")),
			@AttributeOverride(name="zipcode",column=@Column(name="Billing_Zipcode"))
	})
	private Address billingaddress;
	public Person() {}	
	public Person(String name, Address homeaddress,Address billingaddress) {
		this.name = name;
		this.homeaddress = homeaddress;
		this.billingaddress=billingaddress;
	}
	
}
















