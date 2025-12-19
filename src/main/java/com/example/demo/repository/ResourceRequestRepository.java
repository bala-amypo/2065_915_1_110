public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {
    List<ResourceRequest> findByRequestedById(Long id);
}
