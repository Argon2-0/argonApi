package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.PasswordReset;
import vision2cloud.argon.persistence.PasswordResetPersistence;
import vision2cloud.argon.repository.PasswordResetRepository;

import java.util.List;

@Service("PasswordResetImpl")
public class PasswordResetImpl implements PasswordResetPersistence {

    @Autowired
    @Qualifier("PasswordResetRepository")
    PasswordResetRepository passwordResetRepository;

    @Override
    public Object create(PasswordReset passwordReset) {
        return passwordResetRepository.save(passwordReset);
    }

    @Override
    public List<PasswordReset> getPasswordsResets() {
        return passwordResetRepository.findAll();
    }

}
