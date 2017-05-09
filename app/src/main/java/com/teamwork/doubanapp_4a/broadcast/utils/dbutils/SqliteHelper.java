package com.teamwork.doubanapp_4a.broadcast.utils.dbutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.Comment;
import com.teamwork.doubanapp_4a.broadcast.model.Like;
import com.teamwork.doubanapp_4a.broadcast.model.User;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;

import java.lang.reflect.Field;

/**
 *
 */

public class SqliteHelper extends SQLiteOpenHelper {
    //数据库的版本
    private final static int DB_VERSION = 1;
    //数据库名
    private final static String DB_NAME = "Broadcast1.db";

    private Context mContext;

    //我们直接用super调用父类的构造方法，这样我们在实例化DBHelper的时候只需要传入一个上下文参数就可以了
    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.mContext = context;
    }

    //数据库不存在的时候，调用这个方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtil.d("SqliteHelper", "onCreate");
        createTables(db, 0, 0);

        initDatas(db);

    }

    /**
     * 初始化数据
     */
    private void initDatas(SQLiteDatabase db) {
        LogUtil.d("SqliteHelper", "initDatas");
        db.execSQL("INSERT INTO User(icon_url,name) VALUES('https://img3.doubanio.com/icon/up49215882-22.jpg','Iden');");

        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息1','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息2','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息3','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息4','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息5','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('1','测试广播信息6','" + System.currentTimeMillis() + "');");

        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('1','1','测试回应信息1','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('1','1','测试回应信息2','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('1','1','测试回应信息3','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('2','1','测试回应信息4','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('2','1','测试回应信息5','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('2','1','测试回应信息6','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('3','1','测试回应信息7','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('4','1','测试回应信息8','" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Comment(broadcast_id,user_id,content,time) VALUES('5','1','测试回应信息9','" + System.currentTimeMillis() + "');");

        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('1','1', '" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('1','1', '" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('1','1', '" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('2','1', '" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('3','1', '" + System.currentTimeMillis() + "');");
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('5','1', '" + System.currentTimeMillis() + "');");


    }


    //版本号发生变化的时候，调用这个方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //1.删除原来的表
        //2.调用onCreate重新创建数据库
    }

    /**
     * 建表语句，只需要一行就能建一个表
     */
    private void createTables(SQLiteDatabase db, int oldVersion, int newVersion) {
        //createTable(Movie.class)返回的是sql建表语句
        //db.execSQL(sql) 执行这条建表语句
        db.execSQL(createTable(Broadcast.class));
        db.execSQL(createTable(Comment.class));
        db.execSQL(createTable(Like.class));
        db.execSQL(createTable(User.class));
    }

    /**
     * 如果没传表明的话，默认使用类名作为表明
     *
     * @param clazz 实体类
     * @return
     */
    private <T> String createTable(Class<T> clazz) {
        return createTable(clazz, clazz.getSimpleName());
    }

    /**
     * 真正的建表方法
     *
     * @param clazz     实体类
     * @param tableName 表明
     * @return sql建表语句
     */
    private <T> String createTable(Class<T> clazz, String tableName) {

        //实例化一个容器，用来拼接sql语句
        StringBuffer sBuffer = new StringBuffer();
        //sql语句，第一个字段为_ID 主键自增，这是通用的，所以直接写死
        sBuffer.append("create table if not exists " + tableName + " " +
                "(_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        //得到实体类中所有的公有属性
        Field[] fields = clazz.getDeclaredFields();
        //遍历所有的公有属性
        for (Field field : fields) {
            //如果属性不为_id的话，说明是新的字段
            if (!field.getName().equals("id")) {
                //得到属性的基本数据类型
                String type = field.getType().getSimpleName();
                //如果是String类型的属性，就把字段类型设置为TEXT
                if (type.equals("String")) {
                    sBuffer.append(field.getName() + " TEXT,");
                    //如果是int类型的属性，就把字段类型设置为INTEGER
                } else if (type.equals("int") || type.equals("long")) {
                    sBuffer.append(field.getName() + " INTEGER,");
                }

            }
        }
        //将最后的逗号删除
        sBuffer.deleteCharAt(sBuffer.length() - 1);
        //替换成); 表明sql语句结束
        sBuffer.append(");");
        //返回这条sql语句

        LogUtil.d("SqliteHelper",sBuffer.toString());
        return sBuffer.toString();
    }

}