package serves;

import entity.Task;

public interface TaskService {
    void createTask(Long id, String nameTask);
    Task fineById(Long id);
    void deleteById(Long id);
    void updateNameTask(Long id, String newNameTask);
}
