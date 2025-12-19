@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "requestedBy")
    private List<ResourceRequest> requests;

    public User() {}

    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    void init() {
        createdAt = LocalDateTime.now();
        if (role == null) role = "USER";
    }

    // getters & setters (ALL)
}
