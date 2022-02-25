package net.proselyte.springsecuritydemo.rest;

import net.proselyte.springsecuritydemo.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"Ivan", "Ivanov"),
            new Developer(2L,"Sergey", "Sergeev"),
            new Developer(3L,"Piter", "Petrov"),
            new Developer(4L,"Ivan4", "Ivanov4")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id)).findFirst().get();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public List<Developer> create(@RequestBody Developer developer){
        this.DEVELOPERS.add(developer);
        return DEVELOPERS;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id){
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
