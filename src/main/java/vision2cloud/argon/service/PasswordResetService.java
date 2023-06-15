package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.PasswordReset;
import vision2cloud.argon.persistence.Impl.PasswordResetImpl;

import java.util.List;

@Service("PasswordResetService")
public class PasswordResetService {
    @Autowired
    @Qualifier("PasswordResetImpl")
    PasswordResetImpl passwordResetImpl;

    public Object create(PasswordReset passwordReset) {
        return passwordResetImpl.create(passwordReset);
    }

    public List<PasswordReset> getPasswordsResets() {
        return passwordResetImpl.getPasswordsResets();
    }

}
