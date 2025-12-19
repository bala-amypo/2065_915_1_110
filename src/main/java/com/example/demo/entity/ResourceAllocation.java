@Entity
@Table(name = "resource_allocations")
public class ResourceAllocation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @OneToOne
    @JoinColumn(unique = true)
    private ResourceRequest request;

    private LocalDateTime allocatedAt;
    private Boolean conflictFlag;
    private String notes;

    public ResourceAllocation() {}

    public ResourceAllocation(Resource r, ResourceRequest req,
                              Boolean conflict, String notes) {
        this.resource = r;
        this.request = req;
        this.conflictFlag = conflict;
        this.notes = notes;
    }

    @PrePersist
    void init() { allocatedAt = LocalDateTime.now(); }

    // getters & setters
}
