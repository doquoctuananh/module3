package repository.categoryRepository;

import baserepository.BaseRepository;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private BaseRepository baseRepository = new BaseRepository();

    private static String sqlFindAll = "select * from category";
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try(Connection con = baseRepository.getConnection();
            PreparedStatement ppsm = con.prepareStatement(sqlFindAll))
        {
            ResultSet rs = ppsm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return categories;
    }
}
