package ucu.edu.ua;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println))
                   .addTask(new Signature<>(x -> System.out.println(x * x)));

        Group<Integer> group = new Group<>();
        group.addTask(nestedGroup)
             .addTask(new Signature<>(x -> System.out.println(x * x * x)));

        group.apply(10);

        System.out.println("\nGroup ID: " + group.groupUuid);
        for (Task<Integer> task : nestedGroup.getTasks()) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Task groupId: " + task.getHeader("groupId"));
        }
    }
}