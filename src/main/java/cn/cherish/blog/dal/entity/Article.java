package cn.cherish.blog.dal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_article")
public class Article implements java.io.Serializable {

    private static final long serialVersionUID = -5335809584313041094L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;
    /**
     * 简介
     */
    @Column(name = "intro", length = 1024)
    private String intro;
    /**
     * html内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "text")
    private String content;
    /**
     * md内容
     */
    @Column(name = "mdcontent", nullable = false, columnDefinition = "text")
    private String mdcontent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(name = "created_time", length = 19)
    private Date createdTime;

    @Column(name = "read_sum",nullable = false, columnDefinition = "bigint default 0")
    private Long readSum = 0L;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
