package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.PasswordReset;

import java.util.List;

public interface PasswordResetPersistence {
    Object create(PasswordReset passwordReset);
    List<PasswordReset> getPasswordsResets();
}
