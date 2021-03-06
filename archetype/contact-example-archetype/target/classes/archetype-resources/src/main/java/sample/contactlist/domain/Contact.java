#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.contactlist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.ol4jsf.validator.GeometryType;

import ${package}.component.feature.annotation.FeatureName;
import ${package}.query.SRID;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

@Entity
@XmlRootElement(name = "contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotEmpty
	@FeatureName
	private String name;
	
	@Column
	@NotEmpty
	private String telephone;
	
	@Column
	@NotEmpty
    @Email
	private String email;
	
	@Column
	private String address;
	
	@NotNull
	@Type(type = "org.hibernatespatial.GeometryUserType")
	@SRID("4326")
	private Geometry point;
	
	public Contact() {
		super();
	}
	
	public Contact(String name, String telefone, String email) {
		super();
		this.name = name;
		this.telephone = telefone;
		this.email = email;
		
	}
	
	public Contact(String name, String telefone, String email, Geometry point) {
		super();
		this.name = name;
		this.telephone = telefone;
		this.email = email;
		this.point = point;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Geometry getPoint() {
		return point;
	}

	public void setPoint(Geometry point) {
		this.point = point;
	}
	
	
	
	

}
