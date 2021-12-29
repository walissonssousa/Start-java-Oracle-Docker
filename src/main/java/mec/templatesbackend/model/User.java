package mec.templatesbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mec.templatesbackend.model.enums.AuthentificationProvider;
import mec.templatesbackend.model.enums.UserRoler;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name= "usuario")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 254, message = "O username deve conter no máximo 254 caracteres")
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Size(max = 140, message = "O nome completo deve conter no máximo 140 caracteres")
    private String fullName;
    @Size(max = 140, message = "O nome social deve conter no máximo 140 caracteres")
    private String socialName;
    private String picture;
    private String phoneNumber;
    private LocalDate expireAdminRole;
    @Enumerated(EnumType.STRING)
    private AuthentificationProvider provider;

    @ElementCollection(targetClass = UserRoler.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "usuario_papel",
            joinColumns = @JoinColumn(name = "usuario_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "papel", columnDefinition="VARCHAR(50)")
    private Set<UserRoler> roles = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "usuario_authority",
            joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "name") }
    )
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isAdminRoleNonExpired() {
        return (expireAdminRole != null) && expireAdminRole.isAfter(LocalDate.now());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", socialName='" + socialName + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + picture + '\'' +
                "}";
    }
}
