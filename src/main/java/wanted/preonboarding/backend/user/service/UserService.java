package wanted.preonboarding.backend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wanted.preonboarding.backend.common.exception.BusinessExceeption;
import wanted.preonboarding.backend.user.User;
import wanted.preonboarding.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
    }
}
