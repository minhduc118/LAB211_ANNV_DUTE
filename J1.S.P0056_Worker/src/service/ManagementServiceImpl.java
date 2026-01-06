package service;

import constants.Messages;
import exception.DuplicateWorkerException;
import exception.WorkerNotFoundException;
import model.SalaryHistory;
import model.Worker;
import java.util.ArrayList;

public class ManagementServiceImpl implements ManagementService {

    private ArrayList<Worker> workers;
    private ArrayList<SalaryHistory> salaryHistories;

    public ManagementServiceImpl() {
        this.workers = new ArrayList<>();
        this.salaryHistories = new ArrayList<>();
    }

    @Override
    public void addWorker(Worker worker) throws DuplicateWorkerException {
        if (workerExists(worker.getCode())) {
            throw new DuplicateWorkerException(worker.getCode());
        }
        workers.add(worker);
    }

    @Override
    public void changeSalary(String code, double amount, boolean isIncrease) throws WorkerNotFoundException {
        Worker worker = findWorkerByCode(code);
        if (worker == null) {
            throw new WorkerNotFoundException(code);
        }

        if (isIncrease) {
            worker.setSalary(worker.getSalary() + amount);
        } else {
            worker.setSalary(worker.getSalary() - amount);
        }

        String status = isIncrease ? "UP" : "DOWN";
        SalaryHistory history = new SalaryHistory(
                worker.getCode(),
                worker.getName(),
                worker.getAge(),
                worker.getSalary(),
                status);
        salaryHistories.add(history);
    }

    @Override
    public void getInformationSalary() {
        if (salaryHistories.isEmpty()) {
            System.out.println(Messages.ERROR_NO_HISTORY);
            return;
        }

        System.out.println("\n" + Messages.TITLE_DISPLAY_INFO);
        System.out.println(Messages.TABLE_HEADER);

        for (SalaryHistory history : salaryHistories) {
            System.out.println(history);
        }
    }

    private Worker findWorkerByCode(String code) {
        for (Worker worker : workers) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                return worker;
            }
        }
        return null;
    }

    private boolean workerExists(String code) {
        return findWorkerByCode(code) != null;
    }
}
