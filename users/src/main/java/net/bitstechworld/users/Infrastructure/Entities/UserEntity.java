package net.bitstechworld.users.Infrastructure.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bitstechworld.users.Domain.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(user.getEmail(), user.getPassword());
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }




}
