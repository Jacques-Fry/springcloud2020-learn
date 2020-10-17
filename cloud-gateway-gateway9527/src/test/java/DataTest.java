import java.time.ZonedDateTime;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/17 21:52
 */
public class DataTest {

    public static void main(String[] args) {
        //默认时区
        ZonedDateTime zbt=ZonedDateTime.now();
        System.out.println(zbt);
    }
}
