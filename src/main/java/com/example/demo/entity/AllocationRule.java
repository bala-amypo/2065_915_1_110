@Entity
@Table(name = "allocation_rules")
public class AllocationRule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleType;
    private Integer priorityWeight;
    private LocalDateTime createdAt;

    public AllocationRule() {}

    public AllocationRule(String name, String type, Integer weight) {
        this.ruleName = name;
        this.ruleType = type;
        this.priorityWeight = weight;
    }

    @PrePersist
    void init() { createdAt = LocalDateTime.now(); }

    // getters & setters
}
