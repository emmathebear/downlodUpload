package com.develhpe.downlodupload.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "`user`",
        indexes = @Index(unique = true, name = "username_indx", columnList = "username")
)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePicture;
}
