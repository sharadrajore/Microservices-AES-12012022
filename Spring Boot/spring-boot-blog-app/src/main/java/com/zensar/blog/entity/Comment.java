package com.zensar.blog.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity




/*@NamedQueries(value = { @NamedQuery(name = "Comment.commentByItsName", query = "FROM Comment c where c.name=?1"),
		@NamedQuery(name = "Comment.commentByItsNameAndEmail", query = "FROM Comment c where c.name=?1 and c.email=?2")
})*/



//@NamedNativeQueries(value = { @NamedNativeQuery(name = "Comment.commentByItsName", query = "select * FROM Comment  where name=?1",resultClass = Comment.class) })


public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id",nullable = false)
	private Post post;

}
