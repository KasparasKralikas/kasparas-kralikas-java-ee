package lt.mif.vu.mybatis.dao;

import lt.mif.vu.mybatis.model.Bug;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface BugMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUG
     *
     * @mbg.generated Sun Apr 19 22:08:27 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUG
     *
     * @mbg.generated Sun Apr 19 22:08:27 EEST 2020
     */
    int insert(Bug record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUG
     *
     * @mbg.generated Sun Apr 19 22:08:27 EEST 2020
     */
    Bug selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUG
     *
     * @mbg.generated Sun Apr 19 22:08:27 EEST 2020
     */
    List<Bug> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUG
     *
     * @mbg.generated Sun Apr 19 22:08:27 EEST 2020
     */
    int updateByPrimaryKey(Bug record);
}