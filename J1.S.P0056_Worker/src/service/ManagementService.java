package service;

import exception.DuplicateWorkerException;
import exception.WorkerNotFoundException;
import model.Worker;

public interface ManagementService {

    void addWorker(Worker worker) throws DuplicateWorkerException;

    void changeSalary(String code, double amount, boolean isIncrease) throws WorkerNotFoundException;

    void getInformationSalary();
}
