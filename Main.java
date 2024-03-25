import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.*;

class Main {
	public static void main(String[] args) throws IOException {
		new Frame();
	}
}

class Frame extends JFrame implements ActionListener {
	private int fontSize = 24;
	private boolean loaded = false;
	private int pressed = 0;

	private String title1;
	private String title2;
	private String title3;
	private String title4;
	private String title5;

	private final String ID = "msj3381";
	private final String PW = "25601440";

	private CardLayout controlLyt = new CardLayout();

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel controlPnl = new JPanel();
	private JPanel loginPnl = new JPanel();
	private JPanel activityPnl = new JPanel();
	private JButton loginBtn = new JButton();
	private JButton saveBtn = new JButton();
	private JButton loadBtn = new JButton();
	private JButton fontBtn = new JButton();
	private JButton file1Btn = new JButton();
	private JButton file2Btn = new JButton();
	private JButton file3Btn = new JButton();
	private JButton file4Btn = new JButton();
	private JButton file5Btn = new JButton();
	private JTextField loginIdFld = new JTextField();
	private JTextField activityTitleFld = new JTextField();
	private JTextField fontFld = new JTextField();
	private JLabel currentFile = new JLabel();
	private JPasswordField loginPwFld = new JPasswordField();
	private JTextArea activityAre = new JTextArea();
	private JLabel loginBackgroundLbl = new JLabel(new ImageIcon("imgsrc/loginForm.png"));
	private JLabel activityBackgroundLbl = new JLabel(new ImageIcon("imgsrc/activityForm.png"));
	private JLabel loginSucceedLbl = new JLabel("로그인에 성공하였습니다. Joon(" + ID + ")님 반갑습니다.");
	private JLabel loginFailedBecauseAllLbl = new JLabel("아이디 또는 비밀번호가 일치하지 않아 로그인에 실패하였습니다.");
	private JLabel loginFailedBecausePwLbl = new JLabel("아이디에 맞는 비밀번호가 일치하지 않아 로그인에 실패하였습니다.");
	private JLabel pleaseLoad = new JLabel("먼저 파일 불러오기를 시도해주십시오.");
	private JLabel firstInfor = new JLabel("환영합니다! 먼저 불러오기를 시도해주십시오.");
	private JLabel pleaseSelect = new JLabel("먼저 파일을 선택해주십시오.");
	private JLabel completedToSave = new JLabel("저장을 완료하였습니다.");
	private JLabel completedToLoad = new JLabel("모든 문서의 불러오기를 완료하였습니다.");
	private JLabel failedToSave = new JLabel("먼저 문서를 선택해주십시오.");
	private JLabel failedToLoad = new JLabel("이미 문서를 불러왔습니다. 다시 불러오시려면 프로그램을 다시 시작해주십시오.");
	private JLabel pleaseSelectpre = new JLabel("저장을 시도할 문서를 선택해주십시오.");
	private JScrollPane activityAreScl = new JScrollPane(activityAre);

	private String noteDir = "./pad";

	private Path np1 = Paths.get(noteDir, "notepad1.tnp");
	private Path np2 = Paths.get(noteDir, "notepad2.tnp");
	private Path np3 = Paths.get(noteDir, "notepad3.tnp");
	private Path np4 = Paths.get(noteDir, "notepad4.tnp");
	private Path np5 = Paths.get(noteDir, "notepad5.tnp");

	private Path npt1 = Paths.get(noteDir, "npt1.tnt");
	private Path npt2 = Paths.get(noteDir, "npt2.tnt");
	private Path npt3 = Paths.get(noteDir, "npt3.tnt");
	private Path npt4 = Paths.get(noteDir, "npt4.tnt");
	private Path npt5 = Paths.get(noteDir, "npt5.tnt");

	private BufferedReader br1 = Files.newBufferedReader(np1);
	private BufferedReader br2 = Files.newBufferedReader(np2);
	private BufferedReader br3 = Files.newBufferedReader(np3);
	private BufferedReader br4 = Files.newBufferedReader(np4);
	private BufferedReader br5 = Files.newBufferedReader(np5);

	private BufferedReader brt1 = Files.newBufferedReader(npt1);
	private BufferedReader brt2 = Files.newBufferedReader(npt2);
	private BufferedReader brt3 = Files.newBufferedReader(npt3);
	private BufferedReader brt4 = Files.newBufferedReader(npt4);
	private BufferedReader brt5 = Files.newBufferedReader(npt5);

	private List np1l = new List();
	private List np2l = new List();
	private List np3l = new List();
	private List np4l = new List();
	private List np5l = new List();

	// 생성자
	Frame() throws IOException {
		// 현재 파일 라벨
		currentFile.setBounds(85, 643, 39, 35);
		currentFile.setHorizontalAlignment(JTextField.RIGHT);
		currentFile.setFont(new Font("NanumGothic", Font.PLAIN, 28));
		activityPnl.add(currentFile);

		// 파일 목록 버튼 설정: 1번
		file1Btn.setBounds(18, 168, 194, 30);
		file1Btn.setText("1번 문서");
		file1Btn.setBorder(null);
		file1Btn.setHorizontalAlignment(JButton.LEFT);
		file1Btn.setIcon(new ImageIcon("imgsrc/fileBtn1.png"));
		file1Btn.setFont(new Font("NanumGothic", Font.PLAIN, 27));
		file1Btn.addActionListener(this);
		file1Btn.setPressedIcon(new ImageIcon("imgsrc/fileBtnClicked.png"));
		activityPnl.add(file1Btn);

		// 파일 목록 버튼 설정: 2번
		file2Btn.setBounds(18, 198, 194, 30);
		file2Btn.setText("2번 문서");
		file2Btn.setBorder(null);
		file2Btn.setHorizontalAlignment(JButton.LEFT);
		file2Btn.setIcon(new ImageIcon("imgsrc/fileBtn2.png"));
		file2Btn.setFont(new Font("NanumGothic", Font.PLAIN, 27));
		file2Btn.addActionListener(this);
		file2Btn.setPressedIcon(new ImageIcon("imgsrc/fileBtnClicked.png"));
		activityPnl.add(file2Btn);

		// 파일 목록 버튼 설정: 3번
		file3Btn.setBounds(18, 228, 194, 30);
		file3Btn.setText("3번 문서");
		file3Btn.setBorder(null);
		file3Btn.setHorizontalAlignment(JButton.LEFT);
		file3Btn.setIcon(new ImageIcon("imgsrc/fileBtn3.png"));
		file3Btn.setFont(new Font("NanumGothic", Font.PLAIN, 27));
		file3Btn.addActionListener(this);
		file3Btn.setPressedIcon(new ImageIcon("imgsrc/fileBtnClicked.png"));
		activityPnl.add(file3Btn);

		// 파일 목록 버튼 설정: 4번
		file4Btn.setBounds(18, 258, 194, 30);
		file4Btn.setText("4번 문서");
		file4Btn.setBorder(null);
		file4Btn.setHorizontalAlignment(JButton.LEFT);
		file4Btn.setIcon(new ImageIcon("imgsrc/fileBtn4.png"));
		file4Btn.setFont(new Font("NanumGothic", Font.PLAIN, 27));
		file4Btn.addActionListener(this);
		file4Btn.setPressedIcon(new ImageIcon("imgsrc/fileBtnClicked.png"));
		activityPnl.add(file4Btn);

		// 파일 목록 버튼 설정: 5번
		file5Btn.setBounds(18, 288, 194, 30);
		file5Btn.setText("5번 문서");
		file5Btn.setBorder(null);
		file5Btn.setHorizontalAlignment(JButton.LEFT);
		file5Btn.setIcon(new ImageIcon("imgsrc/fileBtn5.png"));
		file5Btn.setFont(new Font("NanumGothic", Font.PLAIN, 27));
		file5Btn.addActionListener(this);
		file5Btn.setPressedIcon(new ImageIcon("imgsrc/fileBtnClicked.png"));
		activityPnl.add(file5Btn);

		// 활성화: 폰트 출력 텍스트 필드 설정
		fontFld.setBounds(75, 526, 95, 65);
		fontFld.setBorder(null);
		fontFld.setHorizontalAlignment(JTextField.RIGHT);
		fontFld.setFont(new Font("NanumGothic", Font.PLAIN, 60));
		fontFld.setText(Integer.toString(fontSize));
		activityPnl.add(fontFld);

		// 활성화: 폰트 크기 버튼 설정
		fontBtn.setBounds(17, 522, 51, 76);
		fontBtn.setIcon(new ImageIcon("imgsrc/activityFontBtn.png"));
		fontBtn.setPressedIcon(new ImageIcon("imgsrc/activityFontBtnClicked.png"));
		fontBtn.setBorder(null);
		fontBtn.addActionListener(this);
		activityPnl.add(fontBtn);

		// 활성화: 제목 입력창
		activityTitleFld.setBounds(356, 0, 918, 49);
		activityTitleFld.setFont(new Font("NanumGothic", Font.BOLD, 26));
		activityTitleFld.setBorder(null);
		activityPnl.add(activityTitleFld);

		// 활성화: 내용 입력창
		activityAre.setBounds(357, 57, 918, 661);
		activityAre.setFont(new Font("NanumGothic", Font.PLAIN, fontSize));
		activityAre.setMargin(new Insets(5, 10, 5, 10));
		activityAreScl.setBounds(350, 50, 925, 666);
		activityAreScl.setFont(new Font("NanumGothic", Font.PLAIN, fontSize));
		activityAreScl.setBorder(null);
		activityPnl.add(activityAreScl);

		// 활성화: 불러오기 버튼 설정
		loadBtn.setBounds(17, 436, 195, 76);
		loadBtn.setIcon(new ImageIcon("imgsrc/activityLoadBtn.png"));
		loadBtn.setPressedIcon(new ImageIcon("imgsrc/activityLoadBtnClicked.png"));
		loadBtn.setBorder(null);
		loadBtn.addActionListener(this);
		activityPnl.add(loadBtn);

		// 활성화: 저장 버튼 설정
		saveBtn.setBounds(17, 350, 195, 76);
		saveBtn.setIcon(new ImageIcon("imgsrc/activitySaveBtn.png"));
		saveBtn.setPressedIcon(new ImageIcon("imgsrc/activitySaveBtnClicked.png"));
		saveBtn.setBorder(null);
		saveBtn.addActionListener(this);
		activityPnl.add(saveBtn);

		// 로그인: 로그인 버튼 설정
		loginBtn.setBounds(468, 376, 542, 56);
		loginBtn.setIcon(new ImageIcon("imgsrc/loginFormBtn.png"));
		loginBtn.setPressedIcon(new ImageIcon("imgsrc/loginFormBtnClicked.png"));
		loginBtn.setBorder(null);
		loginBtn.addActionListener(this);
		loginPnl.add(loginBtn);

		// 로그인: 로그인 아이디 텍스트 필드 설정
		loginIdFld.setBounds(688, 254, 500, 39);
		loginIdFld.setFont(new Font("NanumGothic", Font.PLAIN, 30));
		loginIdFld.setBorder(null);
		loginPnl.add(loginIdFld);

		// 로그인: 로그인 비밀번호 패스워드 필드 설정
		loginPwFld.setBounds(688, 300, 500, 39);
		loginPwFld.setFont(new Font("", Font.PLAIN, 30));
		loginPwFld.setBorder(null);
		loginPnl.add(loginPwFld);

		// 패널 설정
		loginPnl.setLayout(null);
		activityPnl.setLayout(null);

		// 메시지 글꼴 설정
		loginSucceedLbl.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		loginFailedBecauseAllLbl.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		loginFailedBecausePwLbl.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		pleaseLoad.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		firstInfor.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		pleaseSelect.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		completedToSave.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		completedToLoad.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		failedToSave.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		failedToLoad.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		pleaseSelectpre.setFont(new Font("NanumGothic", Font.PLAIN, 15));

		// 메시지 배경
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);

		// 제어 패널 설정
		controlPnl.setLayout(controlLyt);
		controlPnl.add("First", loginPnl);
		controlPnl.add("Second", activityPnl);
		controlLyt.show(controlPnl, "First");

		// 배경 설정
		loginPnl.add(loginBackgroundLbl);
		loginBackgroundLbl.setBounds(0, 0, 1280, 720);
		activityPnl.add(activityBackgroundLbl);
		activityBackgroundLbl.setBounds(0, 0, 1280, 720);

		// 어플리케이션: 기본 설정
		this.add(controlPnl);
		this.setSize(new Dimension(1280, 745));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((int) (screenSize.getWidth() / 2 - 690), (int) (screenSize.getHeight() / 2 - 745 / 2));
		this.setVisible(true);
		this.setTitle("Documents Notepad");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("imgsrc/icon.png"));
		;
	}

	// 이벤트 관리
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			if (ID.equals(loginIdFld.getText()) && PW.equals(loginPwFld.getText())) {
				loginBtn.setIcon(new ImageIcon("imgsrc/loginFormBtnSucceeded.png"));
				JOptionPane.showMessageDialog(this, loginSucceedLbl, "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				controlLyt.show(controlPnl, "Second");
				JOptionPane.showMessageDialog(this, firstInfor, "안내", JOptionPane.INFORMATION_MESSAGE);
				
				
			} else if (ID.equals(loginIdFld.getText()) && !PW.equals(loginPwFld.getText())) {
				JOptionPane.showMessageDialog(this, loginFailedBecausePwLbl, "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
			} else if (!ID.equals(loginIdFld.getText())) {
				JOptionPane.showMessageDialog(this, loginFailedBecauseAllLbl, "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (e.getSource() == fontBtn) {
			fontSize = Integer.parseInt(fontFld.getText());
			fontFld.setText(Integer.toString(fontSize));
			activityAre.setFont(new Font("NanumGothic", Font.PLAIN, fontSize));
		}

		if (e.getSource() == loadBtn) {
			if (loaded == false) {
				String notes;
				String titles;
				try {
					titles = brt1.readLine();
					title1 = titles;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					notes = br1.readLine();
					while (notes != null) {
						np1l.add(notes);
						notes = br1.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					titles = brt2.readLine();
					title2 = titles;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					notes = br2.readLine();
					while (notes != null) {
						np2l.add(notes);
						notes = br2.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					titles = brt3.readLine();
					title3 = titles;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					notes = br3.readLine();
					while (notes != null) {
						np3l.add(notes);
						notes = br3.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					titles = brt4.readLine();
					title4 = titles;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					notes = br4.readLine();
					while (notes != null) {
						np4l.add(notes);
						notes = br4.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					titles = brt5.readLine();
					title5 = titles;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					notes = br5.readLine();
					while (notes != null) {
						np5l.add(notes);
						notes = br5.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				loaded = true;
				JOptionPane.showMessageDialog(this, completedToLoad, "불러오기 성공", JOptionPane.INFORMATION_MESSAGE);
			} else if (loaded == true) {
					JOptionPane.showMessageDialog(this, failedToLoad, "불러오기 실패", JOptionPane.ERROR_MESSAGE);
				}
		}

		if (e.getSource() == saveBtn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "저장 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				if (pressed == 1) {
					try {
						BufferedWriter bw1 = Files.newBufferedWriter(np1);
						BufferedWriter bwt1 = Files.newBufferedWriter(npt1);
						bw1.write(activityAre.getText());
						bwt1.write(activityTitleFld.getText());
						bw1.flush();
						bwt1.flush();
						title1 = activityTitleFld.getText();
						np1l.clear();
						np1l.add(activityAre.getText());
					} catch (IOException e1) {
						e1.printStackTrace(); 
					}
				} else if (pressed == 2) {
					try {
						BufferedWriter bw2 = Files.newBufferedWriter(np2);
						BufferedWriter bwt2 = Files.newBufferedWriter(npt2);
						bw2.write(activityAre.getText());
						bwt2.write(activityTitleFld.getText());
						bw2.flush();
						bwt2.flush();
						title2 = activityTitleFld.getText();
						np2l.clear();
						np2l.add(activityAre.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (pressed == 3) {
					try {
						BufferedWriter bw3 = Files.newBufferedWriter(np3);
						BufferedWriter bwt3 = Files.newBufferedWriter(npt3);
						bw3.write(activityAre.getText());
						bwt3.write(activityTitleFld.getText());
						bw3.flush();
						bwt3.flush();
						title3 = activityTitleFld.getText();
						np3l.clear();
						np3l.add(activityAre.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (pressed == 4) {
					try {
						BufferedWriter bw4 = Files.newBufferedWriter(np4);
						BufferedWriter bwt4 = Files.newBufferedWriter(npt4);
						bw4.write(activityAre.getText());
						bwt4.write(activityTitleFld.getText());
						bw4.flush();
						bwt4.flush();
						title4 = activityTitleFld.getText();
						np4l.clear();
						np4l.add(activityAre.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (pressed == 5) {
					try {
						BufferedWriter bw5 = Files.newBufferedWriter(np5);
						BufferedWriter bwt5 = Files.newBufferedWriter(npt5);
						bw5.write(activityAre.getText());
						bwt5.write(activityTitleFld.getText());
						bw5.flush();
						bwt5.flush();
						title5 = activityTitleFld.getText();
						np5l.clear();
						np5l.add(activityAre.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (pressed == 0) {
					JOptionPane.showMessageDialog(this, pleaseSelectpre, "저장 실패", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, completedToSave, "저장 완료", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (e.getSource() == file1Btn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "파일 편집 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				pressed = 1;
				currentFile.setText("1");
				activityTitleFld.setText(title1);
				activityAre.setText(null);
				for (int i = 0; i < np1l.getItemCount(); i++) {
					activityAre.append(np1l.getItem(i) + "\n");
				}
				activityAre.setCaretPosition(0);
			}
		}

		if (e.getSource() == file2Btn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "파일 편집 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				pressed = 2;
				currentFile.setText("2");
				activityTitleFld.setText(title2);
				activityAre.setText(null);
				for (int i = 0; i < np2l.getItemCount(); i++) {
					activityAre.append(np2l.getItem(i) + "\n");
				}
				activityAre.setCaretPosition(0);
			}
		}

		if (e.getSource() == file3Btn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "파일 편집 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				pressed = 3;
				currentFile.setText("3");
				activityTitleFld.setText(title3);
				activityAre.setText(null);
				for (int i = 0; i < np3l.getItemCount(); i++) {
					activityAre.append(np3l.getItem(i) + "\n");
				}
				activityAre.setCaretPosition(0);
			}
		}

		if (e.getSource() == file4Btn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "파일 편집 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				pressed = 4;
				currentFile.setText("4");
				activityTitleFld.setText(title4);
				activityAre.setText(null);
				for (int i = 0; i < np4l.getItemCount(); i++) {
					activityAre.append(np4l.getItem(i) + "\n");
				}
				activityAre.setCaretPosition(0);
			}
		}

		if (e.getSource() == file5Btn) {
			if (loaded == false) {
				JOptionPane.showMessageDialog(this, pleaseLoad, "파일 편집 실행 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				pressed = 5;
				currentFile.setText("5");
				activityTitleFld.setText(title5);
				activityAre.setText(null);
				for (int i = 0; i < np5l.getItemCount(); i++) {
					activityAre.append(np5l.getItem(i) + "\n");
				}
				activityAre.setCaretPosition(0);
			}
		}
	}
}
