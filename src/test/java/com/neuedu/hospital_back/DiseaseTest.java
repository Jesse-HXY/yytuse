package com.neuedu.hospital_back;

import com.neuedu.hospital_back.mapper.DiseaseMapper;
import com.neuedu.hospital_back.po.Disease;
import com.neuedu.hospital_back.service.DiseaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiseaseTest {

    @Resource
    private DiseaseService diseaseService;

    @Test
    public void getDiseaseType(){
        List<String> diseaseType = diseaseService.getDiseaseType();
        System.out.println(diseaseType);
    }

    @Test
    public void getDiseaseByType(){
        List<Disease> disease = diseaseService.getDiseaseByType("霍乱");
        System.out.println(disease);
    }

   /* @Test
    public void deleteDisease(){
        assertEquals(true, diseaseService.deleteDisease(2067));
    }
*/
    @Test
    public void insertDisease(){
        Disease disease=new Disease();
        disease.setDisIcd("A1111");
        disease.setDisName("公关部");
        assertEquals(true, diseaseService.insert(disease));
    }

    @Test
    public void updateDisease(){
        Disease disease=new Disease();
        disease.setDisName("00ss0");
        disease.setDisId(10001);
        assertEquals(true, diseaseService.updateDisease(disease));
    }
}
