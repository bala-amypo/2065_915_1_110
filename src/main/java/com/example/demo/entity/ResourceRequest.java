@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;

    @ManyToOne
    private User requestedBy;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private String status;

    @OneToOne(mappedBy = "request")
    private ResourceAllocation allocation;

    public ResourceRequest() {}

    public ResourceRequest(String resourceType, User user,
            LocalDateTime start, LocalDateTime end,
            String purpose, String status) {
        this.resourceType = resourceType;
        this.requestedBy = user;
        this.startTime = start;
        this.endTime = end;
        this.purpose = purpose;
        this.status = status;
    }

    // getters & setters
}
