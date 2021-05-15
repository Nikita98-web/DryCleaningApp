package project.models;

import javax.persistence.*;

@Entity
@Table(name="customer_item")
public class CustomerItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private long itemId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	@Column(name="category")
	private String category;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="material")
	private String material;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
