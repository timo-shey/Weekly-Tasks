package Impl;

import CustomException.UsageException;
import Interface.ApplicationService;
import Model.Applicant;
import Model.ConvenienceStore;

public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public void apply(Applicant applicant, ConvenienceStore convenienceStore) throws UsageException {
        if(!convenienceStore.getApplicants().contains(applicant)){
            convenienceStore.getApplicants().add(applicant);
            System.out.println("Hi " + applicant.getFirstName() + ", thank you for your application.");
        } else throw new UsageException("You have already applied for this position.");
    }
}
