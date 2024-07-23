package Run;

import Entites.BangDiem;
import Entites.DiemTB;
import Entites.MonHoc;
import Entites.SinhVien;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static File fileSV = new File("C:\\Users\\84385\\IdeaProjects\\QLDiemSinhVien\\src\\main\\java\\Data\\SinhVien.txt");
    private static File fileMH = new File("C:\\Users\\84385\\IdeaProjects\\QLDiemSinhVien\\src\\main\\java\\Data\\MonHoc.txt");
    private static File fileBD = new File("C:\\Users\\84385\\IdeaProjects\\QLDiemSinhVien\\src\\main\\java\\Data\\BangDiem.txt");
    private static File fileDTB = new File("C:\\Users\\84385\\IdeaProjects\\QLDiemSinhVien\\src\\main\\java\\Data\\DiemTB.txt");
    public static void main(String[] args) {
//        WriteSV(fileSV);
        readSV(fileSV);
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    WriteSV(fileSV);
                    readSV(fileSV);
                    break;
                case 2:
                    WriteMH(fileMH);
                    readMH(fileMH);
                    break;
                case 3:
                    WriteBD(fileBD);
                    readBD();
                    break;
                case 4:
                    SXtheoSV();
                    break;
                case 5:
                    sxtheoMH();
                    break;
                case 6:
                    InDiemTB();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Nhập danh sách đầu sách mới .");
        System.out.println("2. Nhập danh sách bạn đọc mới.");
        System.out.println("3. Lập bảng bang diem.");
        System.out.println("5. Sắp xếp danh sách bang diem theo tên SV.");
        System.out.println("5. Sắp xếp danh sách bang diem theo ten MH.");
        System.out.println("6. In danh sach diem TB");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void WriteSV(File file)
    {
       try
       {
           System.out.println("So luong sinh vien muon nhap :");
           int n = sc.nextInt();
           OutputStream os = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(os);
           for(int i = 1; i <= n ; i++)
           {
               System.out.println("Nhap SV thu " + i);
               System.out.println("Nhap ten :");
               String ten = sc.nextLine();
               if(ten.equals(""))
               {
                   ten = sc.nextLine();
               }
               System.out.println("Nhap lop :");
               String lop = sc.nextLine();
               System.out.println("Nhap dia chi :");
               String diaChi = sc.nextLine();
               System.out.println("Nhap so dien thoai");
               String soDienThoai = sc.nextLine();
               SinhVien obj = new SinhVien(lop,soDienThoai,diaChi,ten);
               oos.writeObject(obj);
               oos.flush();
           }
           oos.close();
       }
       catch (Exception ex)
       {
           ex.printStackTrace();
       }
    }

    private static void readSV(File file) {
        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is)) {
             SinhVien sv = null;
             while (true)
             {
                 sv = (SinhVien) ois.readObject();
                 if(sv == null)
                 {
                     break;
                 }
                 System.out.println(sv.toString());
             }// Cast to SinhVien

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
    }


    private static void WriteMH(File file)
    {
        try
        {
            System.out.println("So luong mon hoc muon nhap :");
            int n = sc.nextInt();
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 1; i <= n ; i++)
            {
                System.out.println("Nhap MH thu " + i);
                System.out.println("Nhap ten mon :");
                String ten = sc.nextLine();
                if(ten.equals(""))
                {
                    ten = sc.nextLine();
                }
                System.out.println("Nhap so don vi hoc trinh :");
                int dvht = sc.nextInt();
                System.out.println("Nhap loai mon :");
                String loai = sc.nextLine();
                if(loai.equals(""))
                {
                    loai = sc.nextLine();
                }
                MonHoc obj = new MonHoc(loai,dvht,ten);
                oos.writeObject(obj);
                oos.flush();
            }
            oos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static void readMH(File file) {
        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            MonHoc sv = null;
            while (true)
            {
                sv = (MonHoc) ois.readObject();
                if(sv == null)
                {
                    break;
                }
                System.out.println(sv.toString());
            }// Cast to SinhVien

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
    }

    private static SinhVien getSV(int id)
    {
        try (InputStream is = new FileInputStream(fileSV);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            SinhVien sv = null;
            while (true)
            {
                sv = (SinhVien) ois.readObject();
                if(sv == null)
                {
                    break;
                }
                if(sv.getMaSV() == id)
                {
                    return sv;
                }
            }// Cast to SinhVien

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
        return null;
    }

    private static MonHoc getMH(int id)
    {
        try (InputStream is = new FileInputStream(fileMH);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            MonHoc sv = null;
            while (true)
            {
                sv = (MonHoc) ois.readObject();
                if(sv == null)
                {
                    break;
                }
                if(sv.getMaMH() == id)
                {
                    return sv;
                }
            }// Cast to SinhVien

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
        return null;
    }

    private static BangDiem getBD(int idMH,int idSV)
    {
        try (InputStream is = new FileInputStream(fileBD);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            BangDiem sv = null;
            while (true)
            {
                sv = (BangDiem) ois.readObject();
                if(sv == null)
                {
                    break;
                }
                if(sv.getIdSV() == idMH && idSV == sv.getIdSV())
                {
                    return sv;
                }
            }// Cast to SinhVien

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
        return null;
    }

    private static void WriteBD(File file)
    {
        try
        {
            System.out.println("So luong bang diem muon nhap :");
            int n = sc.nextInt();
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(int i = 1; i <= n ; i++)
            {
                System.out.println("Nhap BD thu " + i);
                System.out.println("Nhap ID mon Hoc :");
                int idMH = sc.nextInt();
                System.out.println("Nhap ID Sinh Vien :");
                int idSV = sc.nextInt();
                System.out.println("Nhap Diem Sinh Vien :");
                int Diem = sc.nextInt();
                if(Diem > 10 || Diem < 0)
                {
                    System.out.println("Diem phai lon hon 0");
                    break;
                }
                if(getBD(idMH,idSV) != null)
                {
                    System.out.println("Ban ghi da ton tai");
                    break;
                }
                if(getSV(idSV) == null || getMH(idMH) == null)
                {
                    System.out.println("Mon hoc hoac Sinh vien khong ton tai");
                }
                BangDiem obj = new BangDiem(idMH,Diem,idSV);
                oos.writeObject(obj);
                oos.flush();


                int count = 0;
                BangDiem[] lst = new BangDiem[100];
                try (InputStream is = new FileInputStream(fileBD);
                     ObjectInputStream ois = new ObjectInputStream(is)) {


                    BangDiem diem = null;
                    while (true)
                    {
                        diem = (BangDiem) ois.readObject();
                        if(diem.getIdSV() == idSV)
                        {
                            lst[count++] = diem;
                        }
                        if(diem == null)
                        {
                            break;
                        }
                    }
                    System.out.println(diem.toString());
                }
                catch (IOException e) {}
                catch (ClassNotFoundException e) {}
                finally {
                    double Tongdiem = 0;
                    int tongTin = 0;
                    for(int k = 0;k < count; k ++)
                    {
                        Tongdiem += lst[k].getDiem()*getMH(lst[k].getIdMH()).getSoDonViHT();
                        tongTin += getMH(lst[k].getIdMH()).getSoDonViHT();
                    }
                    double TB = Tongdiem / tongTin;
                    try
                    {
                        OutputStream rs = new FileOutputStream(fileDTB);
                        ObjectOutputStream ros = new ObjectOutputStream(rs);
                        DiemTB ob = new DiemTB(idSV,TB,getSV(idSV).getHoTen());
                        ros.writeObject(ob);
                        ros.flush();

                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static void readBD() {
        try (InputStream is = new FileInputStream(fileBD);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            BangDiem sv = null;
            while (true)
            {
                sv = (BangDiem) ois.readObject();
                if(sv == null)
                {
                    break;
                }
                System.out.println(sv.toString());
            }// Cast to SinhVien

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.err.println("Class SinhVien not found for deserialization: " + e.getMessage());
        }
    }

    private static void SXtheoSV()
    {
        int count = 0;
        BangDiem[] lst = new BangDiem[100];
        try (InputStream is = new FileInputStream(fileBD);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            while (true)
            {
                lst[count++] = (BangDiem) ois.readObject();
                if(lst[count-1] == null)
                {
                    break;
                }
            }

        }
        catch (IOException e) {}
        catch (ClassNotFoundException e) {}
        finally {
        for (int i = 0; i < count -2; i++)
        {
            String name1 = getSV(lst[i].getIdSV()).getHoTen();
            for(int j = i + 1; j < count-1; j++)
            {
                String name2 = getSV(lst[j].getIdSV()).getHoTen();
                if(name1.compareTo(name2) < 0)
                {
                    BangDiem temp = lst[j];
                    lst[j] = lst[i];
                    lst[i] = temp;
                }
            }
        }
            for(BangDiem temp : lst)
            {
                if(temp != null)
                {
                    System.out.println(temp.toString());
                }
            }
    }
    }

    private static void sxtheoMH()
    {
        int count = 0;
        BangDiem[] lst = new BangDiem[100];
        try (InputStream is = new FileInputStream(fileBD);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            while (true)
            {
                lst[count++] = (BangDiem) ois.readObject();
                if(lst[count-1] == null)
                {
                    break;
                }
            }

        }
        catch (IOException e) {}
        catch (ClassNotFoundException e) {}
        finally {
            for (int i = 0; i < count -2; i++)
            {
                String name1 = getMH(lst[i].getIdMH()).getTenMon();
                for(int j = i + 1; j < count-1; j++)
                {
                    String name2 = getMH(lst[j].getIdMH()).getTenMon();
                    if(name1.compareTo(name2) < 0)
                    {
                        BangDiem temp = lst[j];
                        lst[j] = lst[i];
                        lst[i] = temp;
                    }
                }
            }
            for(BangDiem temp : lst)
            {
                if(temp != null)
                {
                    System.out.println(temp.toString());
                }
            }
        }
    }

    private static void InDiemTB()
    {
        try (InputStream is = new FileInputStream(fileDTB);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            DiemTB diem = null;
            while (true)
            {
                diem = (DiemTB) ois.readObject();
                if(diem == null)
                {
                    break;
                }
                System.out.println(diem.toString());
            }

        }
        catch (IOException e) {}
        catch (ClassNotFoundException e) {}
    }
}