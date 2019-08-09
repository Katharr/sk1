package main;

import java.sql.*;

public class DBSystem {

    final static int MAX = 20;

    //连接数据库
    private static Connection Conn;
    private static String URL = "jdbc:mysql://8.6.8.58:3306/SHUAKE";
    private static String UserName = "root";
    private static String Password = "123456";

    public static Connection getConnection() {
        try {
            Conn = DriverManager.getConnection(URL, UserName, Password);
            //System.out.println("Connection to DB success!");
            return Conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class VisitSql {

        private static Connection conn;
        private static Statement stt;
        private static ResultSet set;

        public static Object[][] SelectClass() {
            int num = 4;
            Object[][] obj = new Object[MAX][num];
            try {
                conn = DBSystem.getConnection();
                if (Conn == null)
                    return null;
                String sql = "SELECT * FROM ClassTable";
                stt = conn.createStatement();
                set = stt.executeQuery(sql);

                for (int i = 0; set.next(); i++) {
                    for (int j = 0; j < num; j++) {
                        obj[i][j] = set.getString(j + 1);
                    }
                }
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    set.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }

        public boolean AddClass(String ClassId, String ClassPlat, String ClassName, String Price) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "INSERT INTO ClassTable VALUES(?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ClassId);
                ps.setString(2, ClassPlat);
                ps.setString(3, ClassName);
                ps.setString(4, Price);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean DeleteClass(String ClassId) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "DELETE FROM ClassTable WHERE ClassId=?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ClassId);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Deleting closing failed!");
                }
            }
            return true;
        }

        public boolean UpdateClass(String ClassId, String ClassPlat, String ClassName, String Price) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "UPDATE ClassTable SET ClassId=?,ClassPlat=?,ClassName=?,WHERE ClassId=?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ClassId);
                ps.setString(2, ClassPlat);
                ps.setString(3, ClassName);
                ps.setString(4, Price);
                ps.executeUpdate();

            } catch (SQLException e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public static Object[][] SelectOrder() {
            int num = 7;
            Object[][] obj = new Object[MAX][num];
            try {
                conn = DBSystem.getConnection();
                if (Conn == null)
                    return null;
                String sql = "SELECT * FROM OrderTable";
                stt = conn.createStatement();
                set = stt.executeQuery(sql);

                for (int i = 0; set.next(); i++) {
                    for (int j = 0; j < num; j++) {
                        obj[i][j] = set.getString(j + 1);
                    }
                }
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    set.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }

        public boolean AddOrder(String OrderId, String UserId, String ClassId, String UserName, String UserPwd, String CompleteState, String DoingState) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "INSERT INTO OrderTable VALUES(?,?,?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, OrderId);
                ps.setString(2, UserId);
                ps.setString(3, ClassId);
                ps.setString(4, UserName);
                ps.setString(5, UserPwd);
                ps.setString(6, CompleteState);
                ps.setString(7, DoingState);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean DeleteOrder(String OrderId) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "DELETE FROM OrderTable WHERE OrderId=?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, OrderId);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Deleting closing failed!");
                }
            }
            return true;
        }

        public boolean UpdateOrder(String OrderId, String UserId, String ClassId, String UserName, String UserPwd, String CompleteState, String DoingState) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "UPDATE OrderTable SET OrderId=?,UserId=?,ClassId=?,UserName=?,UserPwd=?,CompleteState=?,DoingState=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, OrderId);
                ps.setString(2, UserId);
                ps.setString(3, ClassId);
                ps.setString(4, UserName);
                ps.setString(5, UserPwd);
                ps.setString(6, CompleteState);
                ps.setString(7, DoingState);
                ps.executeUpdate();

            } catch (SQLException e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public static Object[][] SelectUser() {
            int num = 3;
            Object[][] obj = new Object[MAX][num];
            try {
                conn = DBSystem.getConnection();
                if (Conn == null)
                    return null;
                String sql = "SELECT * FROM UserTable";
                stt = conn.createStatement();
                set = stt.executeQuery(sql);

                for (int i = 0; set.next(); i++) {
                    for (int j = 0; j < num; j++) {
                        obj[i][j] = set.getString(j + 1);
                    }
                }
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    set.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }

        public boolean AddSCourse(String UserId, String UserQQ, String Inviter) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "INSERT INTO UserTable VALUES(?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, UserId);
                ps.setString(2, UserQQ);
                ps.setString(3, Inviter);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean DeleteUser(String UserId) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "DELETE FROM UserTable WHERE UserId=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, UserId);
                ps.executeUpdate();

            } catch (Exception e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean UpdateUser(String UserId, String UserQQ, String Inviter) {
            try {
                conn = DBSystem.getConnection();
                if (conn == null)
                    return false;

                String sql = "UPDATE UserTable SET UserQQ=?,Inviter=? WHERE UserId=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, UserQQ);
                ps.setString(2, Inviter);
                ps.setString(3, UserId);
                ps.executeUpdate();

            } catch (SQLException e) {
                return false;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }
}