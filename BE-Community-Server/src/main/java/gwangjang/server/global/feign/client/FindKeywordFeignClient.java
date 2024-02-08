package gwangjang.server.global.feign.client;

import gwangjang.server.domain.community.application.dto.res.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="KEYWORDSERVICE")
public interface FindKeywordFeignClient {




}
