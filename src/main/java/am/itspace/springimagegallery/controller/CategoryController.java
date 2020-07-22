package am.itspace.springimagegallery.controller;

import am.itspace.springimagegallery.model.Category;
import am.itspace.springimagegallery.service.CategoryService;
import am.itspace.springimagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    @Value("D:\\Aram\\IT Space LLC\\My Projects\\Web Projects\\Web (Spring)\\Spring-ImageGallery\\upload")
    private String uploadDir;
    private final CategoryService categoryService;
    private final ImageService imageService;


    @GetMapping("/")
    public String homePage(ModelMap map){
        List<Category> categories = categoryService.findAll();
        map.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("name")String imageName) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }


}
