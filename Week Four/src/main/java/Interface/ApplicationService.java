package Interface;

import CustomException.UsageException;
import Model.Applicant;
import Model.ConvenienceStore;

public interface ApplicationService {
    void apply(Applicant applicant, ConvenienceStore convenienceStore) throws UsageException;
}
