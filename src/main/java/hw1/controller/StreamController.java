package hw1.controller;

import hw1.service.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class StreamController {
    private final StreamService streamService;

    @GetMapping("/stream")
    public String getStream() {
        return streamService.getFullStream().toString();
    }

    @GetMapping("/filter_age")
    public String filterAge() {
        return streamService.getResultOfFilterByAge().toString();
    }

    @GetMapping("/filter_smallest_age")
    public String filterSmallestAge() {
        return streamService.getUserWithTSmallestAge().toString();
    }

    @GetMapping("/filter_biggest_age")
    public String filterBiggestAge() {
        return streamService.getUserWithBiggestAge().toString();
    }

    @GetMapping("/remove_duplicates")
    public String removeDuplicates() {
        return streamService.getResultOfRemovingDuplicates().toString();
    }

    @GetMapping("/sort_age")
    public String sortAge() {
        return streamService.getResultOfSortingByAge().toString();
    }
}
