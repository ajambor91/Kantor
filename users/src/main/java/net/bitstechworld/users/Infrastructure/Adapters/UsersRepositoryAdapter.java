package net.bitstechworld.users.Infrastructure.Adapters;

import lombok.AllArgsConstructor;
import net.bitstechworld.users.Application.Ports.UserRepositoryPort;
import net.bitstechworld.users.Domain.User;
import net.bitstechworld.users.Infrastructure.Entities.UserEntity;
import net.bitstechworld.users.Infrastructure.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
        UserEntity userEntity = UserEntity.fromDomain(user);
        this.userRepository.save(userEntity);
        return User.of(userEntity.getId(), userEntity.getEmail(), userEntity.getCreatedAt());
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByEmail(String email) {
        Optional<UserEntity> user = this.userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("No user found");
        }
        UserEntity userEntity = user.get();
        return User.of(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getCreatedAt());
    }

}
