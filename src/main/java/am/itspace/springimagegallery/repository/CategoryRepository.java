package am.itspace.springimagegallery.repository;

import am.itspace.springimagegallery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
