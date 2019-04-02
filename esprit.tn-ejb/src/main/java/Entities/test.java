package Entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: test
 *
 */
@Entity

public class test implements Serializable {

	   
	@Id
	private Integer id;
	private static final long serialVersionUID = 1L;

	public test() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
