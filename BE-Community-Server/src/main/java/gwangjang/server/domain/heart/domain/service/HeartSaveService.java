package gwangjang.server.domain.heart.domain.service;


import gwangjang.server.domain.heart.domain.entity.Heart;
import gwangjang.server.domain.heart.domain.repository.HeartCustomRepository;
import gwangjang.server.domain.heart.domain.repository.HeartRepository;
import gwangjang.server.global.annotation.DomainService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@DomainService
@Transactional
@RequiredArgsConstructor
public class HeartSaveService {

    private final HeartRepository heartRepository;

    public Heart save(Heart heart) {
        return heartRepository.save(heart);
    }
}
