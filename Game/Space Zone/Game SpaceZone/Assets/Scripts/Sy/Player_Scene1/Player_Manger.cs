using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Player_Manger : MonoBehaviour
{
    private Text txtName;
    private UserResponse userResponse;
    // Start is called before the first frame update
    void Start()
    {
        userResponse = UserResponse.getInstance();

        txtName = GameObject.Find("txtName").GetComponent<Text>();

        txtName.text = userResponse.name;
    }

    // Update is called once per frame
    void Update()
    {

    }
}
