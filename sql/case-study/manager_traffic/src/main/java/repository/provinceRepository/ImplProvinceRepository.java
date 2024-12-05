package repository.provinceRepository;

import model.Province;
import repository.BaseRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplProvinceRepository implements IProvinceRepository{
    private BaseRespository baseRespository = new BaseRespository();

    private static  final String sqlShowAllProvince = "select * from province";
    private static  final String sqlCreateProvince = "insert into province(name) values (?)"  ;
    private static  final String sqlFindProvinceById = "select * from province where code = ?";
    private static  final String sqlUpdateProvince = "update province set name=? where code = ?";
    private static  final String sqlDeleteProvince = "delete from province where code = ?";
    @Override
    public Province findProvinceById(int id) {
        Province province = null;
        try(Connection connection = baseRespository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(sqlFindProvinceById)){
            ppsm.setInt(1, id);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int code = rs.getInt("code");
                String name = rs.getString("name");
                province = new Province(code,name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public List<Province> showAllProvinces() {
        List<Province> provinces = new ArrayList<>();
        try(Connection connection = baseRespository.getConnection();
        PreparedStatement ppsm = connection.prepareStatement(sqlShowAllProvince)){
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int code = rs.getInt("code");
                String name = rs.getString("name");
                Province province = new Province(code,name);
                provinces.add(province);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return provinces;
    }

    @Override
    public boolean createProvince(Province province) {
        boolean result = false;
        try(Connection conn = baseRespository.getConnection();
            PreparedStatement  ppsm = conn.prepareStatement(sqlCreateProvince)
        ){
            ppsm.setString(1,province.getName());
            int row = ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateProvince(Province province) {
        boolean result = false;
        try(Connection conn = baseRespository.getConnection();
            PreparedStatement  ppsm = conn.prepareStatement(sqlUpdateProvince)
        ){
            ppsm.setString(1,province.getName());
            ppsm.setInt(2,province.getCode());
            int row = ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteProvince(int code) {
        boolean result = false;
        try(Connection conn = baseRespository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlDeleteProvince);
        )
        {
            ppsm.setInt(1,code);
            int row = ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
