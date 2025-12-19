@Entity
@Table(name = "resources")
public class Resource {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String resourceName;

    private String resourceType;
    private Integer capacity;
    private String location;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "resource")
    private List<ResourceAllocation> allocations;

    public Resource() {}

    public Resource(String name, String type, Integer capacity, String location) {
        this.resourceName = name;
        this.resourceType = type;
        this.capacity = capacity;
        this.location = location;
    }

    @PrePersist
    void init() { createdAt = LocalDateTime.now(); }

    // getters & setters
}
