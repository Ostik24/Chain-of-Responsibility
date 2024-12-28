import org.junit.jupiter.api.Test;

import ucu.edu.ua.Group;
import ucu.edu.ua.Signature;
import ucu.edu.ua.Task;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {

    @Test
    public void testGroupIdStamping() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(System.out::println));
        group.addTask(new Signature<>(x -> System.out.println(x * x)));

        group.apply(10);

        assertNotNull(group.groupUuid, "Group ID should not be null");

        for (Task<Integer> task : group.getTasks()) {
            assertEquals(group.groupUuid, task.getHeader("groupId"), "Task's groupId should match the group's groupId");
        }
    }
}