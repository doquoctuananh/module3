package repository.provinceRepository;

import model.Province;

import java.util.List;

public interface IProvinceRepository {
    Province findProvinceById(int id);
    List<Province> showAllProvinces();
    boolean createProvince(Province province);
    boolean updateProvince(Province province);
    boolean deleteProvince(int code);
}
