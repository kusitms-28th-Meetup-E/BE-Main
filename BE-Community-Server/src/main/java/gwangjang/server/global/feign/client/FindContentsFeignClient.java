package gwangjang.server.global.feign.client;

import gwangjang.server.domain.community.application.dto.res.ContentsDto;
import gwangjang.server.global.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="contentsService")
public interface FindContentsFeignClient {

    @GetMapping("/{contentsId}")
    ResponseEntity<SuccessResponse<ContentsDto>> getContents(@PathVariable("contentsId") Long contentsId);
}
